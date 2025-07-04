import 'package:flutter/material.dart';

class ProjectDetailScreen extends StatelessWidget {
  const ProjectDetailScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Project Detail'),
      ),
      body: const Center(
        child: Text('Project Detail Screen'),
      ),
    );
  }
}