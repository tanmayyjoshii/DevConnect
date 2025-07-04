import 'package:flutter/material.dart';

class AddProjectScreen extends StatelessWidget {
  const AddProjectScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Add Project'),
      ),
      body: const Center(
        child: Text('Add Project Screen'),
      ),
    );
  }
}