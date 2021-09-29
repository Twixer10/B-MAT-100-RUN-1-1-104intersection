##
## EPITECH PROJECT, 2020
## makefile exe
## File description:
## fct
##

SRCJAVA = src/fr/twixer/intersection/Main.java \
		  src/fr/twixer/intersection/shapes/Cone.java \
		  src/fr/twixer/intersection/shapes/Cylender.java \
		  src/fr/twixer/intersection/shapes/Sphere.java \

SRCCLASS = fr/twixer/intersection/Main.class \
		   fr/twixer/intersection/shapes/Cone.class \
		   fr/twixer/intersection/shapes/Cylender.class \
		   fr/twixer/intersection/shapes/Sphere.class \

SRC = 104intersection.jar

NAME = 104intersection

all:
	mkdir class/
	javac -d ./class $(SRCJAVA)
	cp -r manifest.mf class/
	cd class/ && jar cmf manifest.mf $(SRC) $(SRCCLASS)
	cp -r class/$(SRC) ./
	cp 104intersection.sh $(NAME)
	chmod 755 $(NAME)

clean:
	rm -r class/
	rm $(SRC)

fclean: clean
	rm $(NAME)

re:	fclean all
