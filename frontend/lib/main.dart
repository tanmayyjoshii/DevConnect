import 'package:flutter/material.dart';
import 'package:devconnect/routes.dart'; // Assuming routes.dart is in lib/

void main() {
  runApp(const DevConnectApp());
}

class DevConnectApp extends StatelessWidget {
  const DevConnectApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'DevConnect',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      initialRoute: '/', // Set the initial route
      routes: AppRoutes.routes, // Use the routes defined in routes.dart
    );
  }
}