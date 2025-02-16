# 🏆 Simulation de collecte de joyaux 

Ce projet est une simulation de collecte de joyaux dans une grille, avec des gardiens pour compliquer la tâche.

## 📜 Description du projet

L'objectif est de simuler les déplacements d'un agent sur une grille où il peut collecter des joyaux tout en évitant (ou combattant) des gardiens. Le programme gère :
- 🗺️ Une grille en 2D où sont placés des objets (joyaux, gardiens).
- 🤖 Un agent capable de se déplacer, collecter des joyaux et interagir avec les gardiens.
- ⚔️ Des règles de déplacement et de combat.
- 📊 Une simulation dynamique avec des logs affichant les actions effectuées.

## 📂 Structure du projet

Le projet est composé des fichiers suivants :

- `AgentX.java` 🤖 : Classe représentant l'agent qui explore la grille.
- `Grille.class` 🗺️ : Classe fournie pour gérer la grille.
- `Contenu.class` 📦 : Classe fournie pour représenter les objets sur la grille.
- `Joyau.java` 💎 : Classe représentant les joyaux.
- `Gardien.java` 🛡️ : Classe représentant les gardiens.
- `Simulation.java` 🎮 : Classe principale qui gère la simulation.
- `TestSimulation.java` 🧪 : Programme permettant de tester la simulation.
- `DeplacementIncorrectException.java` 🚨 : Exception levée lors de déplacements invalides.
- `CoordonneesIncorrectesException.java` & `CaseNonPleineException.java` ❌ : Exceptions gérant les erreurs liées à la grille.

## ⚙️ Installation et Compilation

### 🔧 Prérequis
- Java JDK 8 ou supérieur
- Un terminal ou un IDE comme IntelliJ IDEA ou Eclipse

### 🏗️ Compilation
1. Placez tous les fichiers `.java` et les fichiers `.class` fournis dans le même dossier.
2. Compilez le projet avec la commande :
   ```sh
   javac *.java

## 🚀 Exécution  
Lancer la simulation avec :  

```sh
java TestSimulation
