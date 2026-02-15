# Java Mini-Spotify Advanced OOP

This project is a console-based music management system designed to simulate the core logic of Spotify. It was developed as a final challenge for the **DevSenior Code Startup** curriculum to demonstrate proficiency in Java and Object-Oriented Programming (OOP) without the use of advanced collections or external databases.

## Project Scope
The main objective was to realize a functional system using only **fixed-size arrays**, manual object relationships, and fundamental OOP pillars. The application handles user sessions, music catalogs, and playlist management through a CLI (Command Line Interface).

## OOP Principles Applied
This repository serves as a technical portfolio for the following concepts:

* **Abstraction**: Implementation of the `Multimedia` abstract class to define the base structure for audio elements.
* **Interfaces**: Usage of the `Reproducible` interface to decouple the playback logic (`reproducir` and `detener`) from the specific data models.
* **Inheritance & Polymorphism**: The `Cancion` class extends `Multimedia` and implements `Reproducible`, allowing the system to treat songs as generic multimedia or playable objects depending on the context.
* **Method Overloading**: The `Playlist` class includes overloaded methods for `agregarCancion`, enabling the addition of tracks via objects or direct parameters.
* **Encapsulation**: Strict management of attributes using `protected` and `private` modifiers, ensuring data integrity through getters and setters.

## Technical Features
* **Authentication System**: Validation of user credentials to protect access to library and playback features.
* **Manual Array Management**: Handling fixed arrays for the `BibliotecaMusical` and `Playlist` classes, including capacity checks and counter management.
* **Search Engine**: Logic to search songs by name or fragments within the global catalog.
* **Interactive Menu**: A robust menu system that guides the user through sub-menus for library management and real-time playback simulation.

## Project Structure
```text
src/
├── modelo/          # Data models and logic
│   ├── Reproducible.java
│   ├── Multimedia.java
│   ├── Cancion.java
│   ├── Playlist.java
│   ├── BibliotecaMusical.java
│   └── CuentaSpotify.java
├── app/             # Main execution
│   └── App.java
└── utils/           # Input handling (Scanner)
