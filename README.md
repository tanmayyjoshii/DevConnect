# 📘 DevConnect – Full Stack Developer Networking & Job Platform

⸻

## 🧩 Overview

DevConnect is a full-stack platform designed for developers and recruiters to connect, showcase work, and hire based on skill and real contributions—not just resumes. It allows:
	•	Developers to create profiles, list skills, and showcase GitHub-linked projects.
	•	Startups/recruiters to post jobs, filter developers by tech stack.
	•	Users to chat, apply for jobs, and view real-time verified dev profiles.

⸻

## 🏗️ System Architecture

1.  **Frontend**
    *   Technology: Flutter (cross-platform - Web, Android, iOS)
    *   Responsibilities:
        *   UI screens for login, profile, job listings, project feed
        *   REST API integration
        *   Firebase chat (real-time messaging)

2.  **Backend**
    *   Technology: Java Spring Boot
    *   Modules:
        *   User Authentication (JWT, Spring Security)
        *   Profile Management (Developer data, skills, resume links)
        *   Jobs Module (Post, apply, filter jobs)
        *   Project Showcase (Submit/view GitHub-linked projects)
        *   Chat Integration API (for Firebase/WebSocket)
        *   REST APIs with Swagger Documentation

3.  **Database**
    *   PostgreSQL for structured data (users, jobs, projects)
    *   Redis (optional) for caching frequently accessed data

4.  **Storage**
    *   Firebase Storage / AWS S3 for profile pictures, resumes

5.  **Real-Time Features**
    *   Firebase Firestore for real-time chat messaging and DM notifications

⸻

## 📁 Folder Structure (Backend)

```
backend/
├── src/main/java/com/devconnect/
│   ├── config/              # SecurityConfig, JWT filters
│   ├── controller/          # API Controllers (Auth, User, Job, Project)
│   ├── model/               # Entity Classes (User, Job, Project)
│   ├── repository/          # JPA Repositories
│   ├── security/            # JWT utilities and filters
│   ├── service/             # Business logic layer
│   └── DevConnectApplication.java
└── resources/
    ├── application.properties
    └── schema.sql (optional init script)
```

⸻

## 🔐 Authentication System
	•	JWT + Spring Security
	•	Auth endpoints:
	•	POST /api/auth/register – Register new developer
	•	POST /api/auth/login – Login with email + password
	•	JWT token returned on login/register and passed in Authorization: Bearer <token> header
	•	Roles Supported: USER, ADMIN

⸻

## 👤 User Module

**Fields**

```json
{
  "id": "UUID",
  "name": "String",
  "email": "String",
  "password": "Encrypted",
  "bio": "String",
  "skills": ["Java", "Flutter"],
  "githubLink": "https://github.com/username",
  "resumeLink": "Firebase/AWS link",
  "role": "USER"
}
```

**APIs**
	•	GET /api/users/me – Get current user profile
	•	PUT /api/users/me – Update profile

⸻

## 💼 Job Module

**Fields**

```json
{
  "id": "UUID",
  "title": "Backend Developer",
  "description": "Looking for Spring Boot developer...",
  "stipend": 15000,
  "stack": ["Java", "PostgreSQL"],
  "type": "REMOTE | ONSITE",
  "postedBy": "User ID"
}
```

**APIs**
	•	POST /api/jobs – Create new job
	•	GET /api/jobs – List all jobs (filter by stack)
	•	GET /api/jobs/{id} – View job details
	•	POST /api/jobs/apply/{jobId} – Apply to a job
	•	GET /api/jobs/applied – See applied jobs by user

⸻

## 🚀 Project Module

**Fields**

```json
{
  "id": "UUID",
  "title": "Portfolio App",
  "description": "Built with Flutter & Firebase",
  "techUsed": ["Flutter", "Firebase"],
  "githubLink": "https://github.com/...",
  "submittedBy": "User ID"
}
```

**APIs**
	•	POST /api/projects – Submit new project
	•	GET /api/projects – View all projects
	•	GET /api/projects/{id} – View single project
	•	POST /api/projects/like/{id} – Like project
	•	POST /api/projects/comment/{id} – Comment on project

⸻

## 💬 Real-Time Chat Module
	•	Uses: Firebase Firestore / Firebase Realtime DB
	•	Structure:

```
/messages/
  chatId: {
    user1: <userId>,
    user2: <userId>,
    messages: [
      {
        sender: <userId>,
        text: "Hey! I'm interested in your job post.",
        timestamp: <ISO 8601>
      }
    ]
  }
```

	•	Real-time sync handled by Firebase listeners in Flutter

⸻

## 🧠 Bonus Feature – Job Recommendation System (Optional)
	•	Use Spring + Lightweight ML model to recommend jobs based on:
	•	Developer’s skill set
	•	Projects built
	•	Jobs previously applied to

⸻

## 🧪 API Documentation
	•	Integrated via SpringDoc Swagger
	•	Available at:
http://localhost:8080/swagger-ui.html
or
/api-docs

⸻

## 🚀 Deployment

| Component | Platform                  |
| :-------- | :------------------------ |
| Backend   | Railway / Render          |
| Frontend  | Firebase Hosting / Vercel |
| DB        | Supabase / Render PostgreSQL |
| Storage   | Firebase Storage or AWS S3 |


⸻

## 📅 MVP Timeline

| Week | Features                                            |
| :--- | :-------------------------------------------------- |
| 1    | Setup backend + JWT Auth + Register/Login + User profile |
| 2    | Job CRUD + Project CRUD + filtering                 |
| 3    | Firebase Chat + UI polish + Deployment              |
| 4    | (Bonus) Recommendation engine + Resume/GitHub insights |


⸻

## ✅ Tech Stack Summary

| Layer    | Tech                                  |
| :------- | :------------------------------------ |
| Frontend | Flutter                               |
| Backend  | Java Spring Boot                      |
| Auth     | Spring Security + JWT                 |
| Database | PostgreSQL + Redis (optional)         |
| Storage  | Firebase / AWS S3                     |
| Chat     | Firebase Firestore / WebSocket        |
| API Docs | Swagger (OpenAPI)                     |
| Hosting  | Render, Firebase Hosting, Railway     |


⸻

## 🧾 Submission Notes for Jules AI / Firebase Studio AI

**Tips:**
	•	Share this markdown as README or PDF.
	•	Include your Swagger API URL, GitHub link, and Firebase demo.
	•	Mention the tech breakdown, architecture, and API structure clearly.

⸻
