import 'package:flutter/material.dart';

class ProjectListScreen extends StatelessWidget {
  const ProjectListScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Project Showcase'),
      ),
      body: Center(
        child: Text('Project List Screen'),
      ),
    );
  }
}