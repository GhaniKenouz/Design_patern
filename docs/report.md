# L3 design pattern report

- **Firstname**: [Kenouz]
- **Lastname**: [Abdelghani]


> Add your thoughts on every TP bellow, everything is interresting but no need to right a book.

TP2

# L3 Design Pattern Report

- **Firstname**: DJOUE
- **Lastname**: ARIEL EMMANUEL KOUADIO

---
> Nouveauté 

- La première tâche du script est de gérer les options passées en ligne de commande et de renvoyer une erreur en fonction du résultat. L'analyse des arguments est séparée de la gestion des erreurs avec la classe `CommandLineProcessor` implémentant `CommandProcessor`.
- Une fonction spécifique est implémentée pour récupérer l'argument passé en ligne de commande dans la classe `MyCommandProcessor`.
- L'interface `ArgumentValidator` et la classe `PositionalArgumentValidator` sont ajoutées pour valider les arguments positionnels, respectant le principe SOLID.
- Des instructions sont ajoutées dans la méthode `processCommand` de la classe `CommandLineProcessor` pour gérer les erreurs.
- La récupération du contenu du fichier suit le même principe avec les classes `PathValidator` et `FileReader` pour séparer la vérification du chemin de la lecture du fichier.
- Une structure conditionnelle pour vérifier si la commande vaut `insert` ou `list` est remplacée par une table de correspondance, évitant ainsi une surabondance de `if`.
- Une table de correspondance (`commandRegistry`) est utilisée avec la fonction `createCommandExecutor(command)` pour déterminer la commande à exécuter.
- Des classes spécifiques sont créées pour chaque commande, suivant le modèle d'interface `Command`.
- Des méthodes privées spécifiques à chaque classe sont ajoutées pour la lecture et l'insertion en fonction de l'extension du fichier (`csv` ou `json`).
- Le code final est séparé en différents packages pour améliorer la lisibilité.

> Tâche du jour

- Ajout de la fonctionnalité permettant de marquer une tâche comme `done`.
- Utilisation d'une table de correspondance pour déterminer la commande avec un diagramme expliquant la fonctionnalité.
- La méthode `execute` prend un nouveau paramètre pour spécifier si la commande contient l'option `done`.
- Utilisation d'un nouveau format pour vérifier si la tâche est marquée comme `done` dans les fichiers `json`.
- Blocage résolu sur le code utilisant `Arrays.stream` grâce à l'utilisation d'une solution qui évite le caractère `\n` lorsqu'il ne trouve pas `Done` dans la chaîne.

TP1
> Qu'est-ce que j'ai fait et pourquoi :

- J'ai développé une application de gestion de tâches simples en ligne de commande en utilisant Java.

- Le code est structuré en utilisant des principes SOLID et des design patterns pour améliorer la lisibilité, la maintenabilité et l'extensibilité du code.

- J'ai introduit une approche basée sur des interfaces et des fabriques pour créer dynamiquement des instances de commandes, permettant l'ajout facile de nouvelles
  fonctionnalités.

> Qu'est-ce qui m'a aidé et pourquoi :

- J'ai eu l'aide de mon collegue Emmanuel qui à pu me conseiller et me guider vers des méthodes plus efficace 
- L'utilisation de l'approche basée sur des interfaces et des fabriques a simplifié l'ajout de nouvelles commandes sans modifier la logique du code principal.

- Les principes SOLID ont guidé la conception des classes, favorisant une structure flexible et bien organisée.

> Qu'est-ce qui m'a semblé difficile :

- La gestion des différents types de fichiers (JSON, CSV) et la logique associée ont demandé une attention particulière.

- La mise en place de la fabrique de commandes a nécessité une compréhension approfondie des concepts d'interfaces fonctionnelles en Java.

> Qu'est-ce qui ne m'a pas aidé :

- La gestion des exceptions et des erreurs pourrait être encore améliorée pour rendre l'application plus robuste.

- La comprehension du code et la manière de s'y prendre

> Qu'avais-je besoin de changer :
- Le programme n'etait pas bien structuré, beaucoup d'ajustements pourraient être apportés pour bien rendre le programme lisible et l'optimiser avec des fonctions.

>
> Remember: it is ok to make mistakes, you will have time to spot them later.
>
> Fill free to contact me if needed.

---
...
