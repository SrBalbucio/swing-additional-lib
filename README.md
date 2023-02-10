[![](https://jitpack.io/v/SrBalbucio/SwingLib.svg)](https://jitpack.io/#SrBalbucio/SwingLib)
# SwingLib
Esse repositório tem como objetivo trazer ferramentas, componentes e layouts para o seu projeto em Java Swing.<br>
This repository aims to bring tools, components and layouts to your Java Swing project.

## Content
Todos os componentes presentes na libraria estão listados abaixo:
### Componentes:
- JImage (Crie uma imagem)
### Panel
- JPanelWithBackground (Crie um Panel com imagem de fundo)
- JCornerPanel (Crie um Panel arredondado)
### Border
- DropShadowBorder (Borda com sombra)

## Ferramentas
Todas as ferramentas presentes na libraria estão listadas abaixo:
- ImageUtils (Carregue, edite e manipule imagens)

## Importando
Se você usa maven:
```maven
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

<dependency>
	    <groupId>com.github.SrBalbucio</groupId>
	    <artifactId>SwingLib</artifactId>
            <version>main-SNAPSHOT</version>
	</dependency>
```
Se você usa Gradle:
```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  	dependencies {
	        implementation 'com.github.SrBalbucio:SwingLib:main-SNAPSHOT'
	}
```
Para mais opções: https://jitpack.io/#SrBalbucio/SwingLib/main-SNAPSHOT
