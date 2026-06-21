import 'dart:convert';
import 'package:flutter/cupertino.dart';
import 'package:http/http.dart' as http;
import '../config/api_config.dart';

class ArticleService {

  static const String baseUrl =
      'http://192.168.137.222:8090/api/articles';

  Future<List<dynamic>> getArticles() async {
    try {
      final response = await http.get(
        Uri.parse('${ApiConfig.baseUrl}/api/articles'),
      );

      debugPrint(response.body);
      if (response.statusCode == 200) {
        return jsonDecode(response.body);
      }

      throw Exception(
        'Erreur serveur : ${response.statusCode}',
      );
    } catch (e) {
      throw Exception(
        'Impossible de récupérer les articles : $e',
      );
    }
  }
}