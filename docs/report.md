# L3 design pattern report

- **Firstname**: [Kenouz]
- **Lastname**: [Abdelghani]

# L3 Design Pattern Report

> Add your thoughts on every TP bellow, everything is interresting but no need to right a book.

TP3

-Dans le cadre du TP3, nous avons étendu les fonctionnalités de notre application en ajoutant une nouvelle commande appelée "migrate". 
Cette commande vise à transférer les données d'un fichier source vers un fichier de destination pour les extensions prises en charge par notre système.

-Pour ce faire, j'ai créé une nouvelle classe appelée MigrateCommand qui implémente l'interface Command. Cette classe est responsable de la gestion de la commande "migrate".

-De plus, une nouvelle option de commande, facultative et prenant un argument, a été introduite, à savoir l'option --output. 
Cette option spécifie le fichier de destination pour la migration des données.

-La méthode execute() de la classe MigrateCommand n'apporte rien de nouveau en termes de fonctionnalités, 
car elle utilise les mêmes méthodes de lecture et d'écriture que celles déjà implémentées pour les autres commandes.

-Il convient de noter que la méthode d'écriture write() a été modifiée pour accepter une liste de todos plutôt qu'une seule todo, 
afin de faciliter la migration de plusieurs tâches à la fois.

-En outre, grâce aux explications fournies par Emmanuel, 
-j'ai pu avancer dans le développement du TP en comprenant mieux les besoins et en utilisant ses conseils pour structurer efficacement le code. 
Ses explications m'ont aidé à clarifier certains aspects du TP et à mieux comprendre comment intégrer de nouvelles fonctionnalités dans l'application existante.

Ce que j'ai compris :

> Nouveauté

> Utiliser des booléens et des instructions if pour abstraire les données peut entraîner une complexité accrue et une maintenance plus difficile de votre code, 
en particulier lorsque vous traitez avec plusieurs états ou conditions. Voici quelques raisons pour lesquelles cette approche peut ne pas être conseillée pour l'abstraction des données : 

> Manque de lisibilité : L'utilisation excessive de booléens et de conditions if peut rendre votre code difficile à lire et à comprendre, surtout lorsque vous avez plusieurs conditions imbriquées. 
> Risque d'erreurs : Avec des instructions if multiples et des booléens pour représenter les états, il est facile de commettre des erreurs logiques, telles que des oublis de cas ou des contradictions dans la logique du code. 
> Difficulté à maintenir : Au fur et à mesure que votre code évolue et que de nouveaux cas d'utilisation sont ajoutés, la gestion des booléens et des conditions if peut devenir de plus en plus complexe. Cela rend la maintenance difficile et augmente le risque d'introduire des bogues. 
> Manque d'extensibilité : Si vous devez ajouter de nouveaux états ou conditions à l'avenir, vous devrez peut-être modifier de nombreuses parties de votre code existant pour prendre en compte ces changements, ce qui peut entraîner des régressions non intentionnelles. 
> Violation du principe d'encapsulation : L'utilisation de booléens pour représenter l'état interne d'un objet peut violer le principe d'encapsulation, car cela expose généralement trop de détails d'implémentation de l'objet.

La méthode la plus appropriée et conseillée pour l'abstraction des données dépend souvent du contexte spécifique de votre application, 
de la complexité des données à abstraire et des besoins de votre projet. Cependant, 
voici quelques approches couramment utilisées et généralement recommandées pour l'abstraction des données :

-1. Utilisation d'énumérations (Enum) : Les énumérations sont souvent utilisées pour représenter des ensembles finis de valeurs qui sont liées à un type spécifique. Elles offrent une manière simple et sûre de définir des constantes et sont idéales pour représenter des états, 
des types ou des options prédéfinies.

-2. Utilisation de classes et d'objets : L'encapsulation des données dans des classes et l'utilisation de méthodes pour accéder et modifier ces données est une approche fondamentale de la programmation orientée objet. 
Elle permet de regrouper les données et le comportement associé dans une seule entité, facilitant ainsi la gestion et la manipulation des données.
TP2


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
