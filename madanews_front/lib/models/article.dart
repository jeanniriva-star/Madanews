class Article {
  final int? id;
  final String title;
  final String description;
  final String category;
  final String date;
  final String content;
  final String? imageUrl;

  const Article({
    this.id,
    required this.title,
    required this.description,
    required this.category,
    required this.date,
    required this.content,
    this.imageUrl,
  });
}