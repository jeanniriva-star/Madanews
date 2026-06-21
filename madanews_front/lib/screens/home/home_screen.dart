import 'package:flutter/material.dart';
import '/widgets/news_card.dart';
import '/widgets/featured_news_card.dart';
import '/screens/article/article_detail_screen.dart';
import '/models/article.dart';
import 'dart:async';
import '/services/article_service.dart';
import '/data/article_store.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  String selectedCategory = "Tous";
  String searchQuery = "";
  Timer? _debounce;
  final TextEditingController searchController = TextEditingController();




  List<Article> articles = [];
  bool isLoading = true;

  final ArticleService articleService = ArticleService();

  void toggleFavorite(Article article) {
    setState(() {
      if (ArticleStore.favorites.contains(article.title)) {
        ArticleStore.favorites.remove(article.title);
      } else {
        ArticleStore.favorites.add(article.title);
      }
    });
  }
  Future<void> loadArticles() async {
    try {
      final data = await articleService.getArticles();

      setState(() {
        ArticleStore.articles = data.map<Article>((json) {
          return Article(
            id: json["idArticles"],
            title: json["titreArt"] ?? "",
            description: json["contenu"] ?? "",
            category: json["categorie"]["nomCat"] ?? "",
            date: json["datePublicationArt"] ?? "",
            content: json["contenu"] ?? "",
            imageUrl: json["image"],
          );
        }).toList();
        articles = ArticleStore.articles;

        isLoading = false;
      });
    } catch (e) {
      setState(() {
        isLoading = false;
      });

      debugPrint(e.toString());
    }
  }


  @override
  void initState() {
    super.initState();
    loadArticles();
  }
  @override
  Widget build(BuildContext context) {
    final categories = [
      "Tous",
      "Politique",
      "E"
          "conomie",
      "Société",
      "Sport",
      "Culture",
      "Technologie",
      "International",
    ];

    final filteredArticles = articles.where((article) {
      final matchCategory =
          selectedCategory == "Tous" ||
              article.category == selectedCategory;

      final query = searchQuery.toLowerCase();

      final matchSearch =
          article.title.toLowerCase().contains(query) ||
              article.description.toLowerCase().contains(query) ||
              article.content.toLowerCase().contains(query) ||
              article.category.toLowerCase().contains(query);

      return matchCategory && matchSearch;
    }).toList();

    if (isLoading) {
      return const Center(
        child: CircularProgressIndicator(),
      );
    }

    return SingleChildScrollView(
      padding: const EdgeInsets.all(16),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          // 🔎 SEARCH BAR
          TextField(
            controller: searchController,
            onChanged: (value) {
              if (_debounce?.isActive ?? false) _debounce!.cancel();

              _debounce = Timer(const Duration(milliseconds: 300), () {
                setState(() {
                  searchQuery = value;
                });
              });
            },
            decoration: InputDecoration(
              hintText: "Rechercher une actualité...",
              prefixIcon: const Icon(Icons.search),

              suffixIcon: searchQuery.isNotEmpty
                  ? IconButton(
                icon: const Icon(Icons.clear),
                onPressed: () {
                  setState(() {
                    searchQuery = "";
                    searchController.clear(); // 🔥 IMPORTANT FIX
                  });
                },
              )
                  : null,

              border: OutlineInputBorder(
                borderRadius: BorderRadius.circular(15),
              ),
            ),
          ),

          const SizedBox(height: 20),

          const Text(
            "Catégories",
            style: TextStyle(
              fontSize: 20,
              fontWeight: FontWeight.bold,
            ),
          ),

          const SizedBox(height: 10),

          SizedBox(
            height: 45,
            child: ListView.builder(
              scrollDirection: Axis.horizontal,
              itemCount: categories.length,
              itemBuilder: (context, index) {
                return Container(
                  margin: const EdgeInsets.only(right: 8),
                  child: GestureDetector(
                    onTap: () {
                      setState(() {
                        selectedCategory = categories[index];
                      });
                    },
                    child: Chip(
                      backgroundColor: selectedCategory == categories[index]
                          ? Colors.red
                          : Colors.grey.shade200,
                      label: Text(
                        categories[index],
                        style: TextStyle(
                          color: selectedCategory == categories[index]
                              ? Colors.white
                              : Colors.black,
                        ),
                      ),
                    ),
                  ),
                );
              },
            ),
          ),

          const SizedBox(height: 25),

          const Text(
            "À la une",
            style: TextStyle(
              fontSize: 20,
              fontWeight: FontWeight.bold,
            ),
          ),

          const SizedBox(height: 10),

          FeaturedNewsCard(
            title: "Titre principal de l'actualité",
            description:
            "Résumé de l'actualité la plus importante du moment.",
            category: "Politique",
            date: "Aujourd'hui",
            onTap: () {
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (_) => const ArticleDetailScreen(
                    title: "Titre principal de l'actualité",
                    category: "Politique",
                    date: "Aujourd'hui",
                    content:
                    "Ici sera affiché le contenu complet de l'article.",
                  ),
                ),
              );
            },
          ),

          const SizedBox(height: 20),

          const Text(
            "Actualités récentes",
            style: TextStyle(
              fontSize: 20,
              fontWeight: FontWeight.bold,
            ),
          ),

          const SizedBox(height: 10),

          // 📭 EMPTY STATE
          if (filteredArticles.isEmpty)
            const Padding(
              padding: EdgeInsets.symmetric(vertical: 40),
              child: Center(
                child: Column(
                  children: [
                    Icon(
                      Icons.search_off,
                      size: 60,
                      color: Colors.grey,
                    ),
                    SizedBox(height: 10),
                    Text(
                      "Aucun résultat trouvé",
                      style: TextStyle(
                        fontSize: 18,
                        fontWeight: FontWeight.bold,
                        color: Colors.grey,
                      ),
                    ),
                    SizedBox(height: 5),
                    Text(
                      "Essayez un autre mot-clé",
                      style: TextStyle(
                        color: Colors.grey,
                      ),
                    ),
                  ],
                ),
              ),
            )
          else
            ...filteredArticles.map(
                  (article) =>NewsCard(

                    title: article.title,
                    description: article.description,
                    category: article.category,
                    date: article.date,
                    onTap: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (_) => ArticleDetailScreen(
                            title: article.title,
                            category: article.category,
                            date: article.date,
                            content: article.content,
                          ),
                        ),
                      );
                    },

                    trailing: IconButton(
                      icon: Icon(
                        ArticleStore.favorites.contains(article.title)
                            ? Icons.favorite
                            : Icons.favorite_border,
                        color:ArticleStore.favorites.contains(article.title)
                            ? Colors.red
                            : Colors.grey,
                      ),
                      onPressed: () => toggleFavorite(article),
                    ),
                  )
            ),
        ],
      ),
    );
  }
  @override
  void dispose() {
    _debounce?.cancel();
    searchController.dispose();
    super.dispose();
  }

  List<Article> get favoriteList {
    return ArticleStore.articles
        .where(
          (article) =>
          ArticleStore.favorites.contains(article.title),
    )
        .toList();
  }
}