# ClientTournoiRobotsEssaimJava

![Screen](https://github.com/KASDmusic/ClientTournoiRobotsEssaimJava/blob/main/img/gui.png)

## Résumé

Dans un espace donné, un nombre X de robots ainsi qu'une balise sont disposés aléatoirement.  
Le principe est de désamorcer la balise à l'aide des robots en un nombre tour le plus petit possible.  
Seulement, chaque robot doit fonctionner avec le même code.  
Vous devez donc adapter votre logique pour qu'un même code agisse intelligement en fonction de chaque circonstance !  

#### Informations supplémentaires

* Chaque robot dispose d'une portée grâce à laquelle il peut soit désamorcer la balise, soit communiquer des informations avec d'autres robots.
* Chaque robot stocke automatiquement les coordonnées de la balise si il la croise.
* Chaque robot communique automatiquement les coordonnées de la balise aux autres robots si il l'a déjà croisé.

Utilisez donc ces informations pour créer un code intelligent ! (D'autres données sont également disponibles)  
Pour plus d'informations, lisez la documentation.

## Architecture

L'architecture logicielle mis en place est le **MVC** *(Model-View-Controller)* en respectant au mieux les règles d'élégance du code *(clean code)*.  
  
* Le repertoire *src* contient le code source du jeu.

## Environnement

Ce projet est réalisé en **Java 11** *(OpenJDK)*.

### Exécution

Récupération du projet:
~~~
    git clone https://github.com/KASDmusic/TournoiRobotsEssaimJava.git
~~~

> Lien pour uploader votre code, voir le classement et autre : [non](https://github.com/KASDmusic/ClientTournoiRobotsEssaimJava) 
\
> Lien vers le repository git du serveur : [serveur](https://github.com/KASDmusic/ServerTournoiRobotsEssaimJava)  

