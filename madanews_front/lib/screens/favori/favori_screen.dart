import 'package:flutter/material.dart';
import '/data/article_store.dart';
import '/widgets/news_card.dart';
import '/screens/article/article_detail_screen.dart';

class FavorisScreen extends StatefulWidget {
  const FavorisScreen({super.key});

  @override
  State<FavorisScreen> createState() => _FavorisScreenState();
}

class _FavorisScreenState extends State<FavorisScreen> {
  @override
  Widget build(BuildContext context) {
    final favoriteArticles = ArticleStore.articles
        .where(
          (article) =>
          ArticleStore.favorites.contains(article.title),
    )
        .toList();

    if (favoriteArticles.isEmpty) {
      return const Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(
              Icons.favorite_border,
              size: 70,
              color: Colors.grey,
            ),
            SizedBox(height: 10),
            Text(
              "Aucun favori",
              style: TextStyle(
                fontSize: 18,
                fontWeight: FontWeight.bold,
              ),
            ),
          ],
        ),
      );
    }

    return ListView.builder(
      padding: const EdgeInsets.all(16),
      itemCount: favoriteArticles.length,
      itemBuilder: (context, index) {
        final article = favoriteArticles[index];

        return NewsCard(
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
        );
      },
    );
  }
}