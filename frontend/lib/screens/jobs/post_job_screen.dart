import 'package:flutter/material.dart';

class PostJobScreen extends StatelessWidget {
  const PostJobScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Post New Job'),
      ),
      body: Center(
        child: Text('Post Job Screen'),
      ),
    );
  }
}