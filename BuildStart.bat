@echo off
echo """""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
echo "                                              _       _              "
echo "                                _            I I     (_)             "
echo " ____  _____  ____ _____ ____ _| |_ _____  __| | ____ _ _   _ _____  "
echo "|    \(____ |/ _  | ___ |  _ (_   _|____ |/ _  |/ ___) | | | | ___ | "
echo "| | | / ___ ( (_| | ____| | | || |_/ ___ ( (_| | |   | |\ V /| ____| "
echo "|_|_|_\_____|\___ |_____)_| |_| \__)_____|\____|_|   |_| \_/ |_____) "
echo "            (_____|                                                  "
echo """""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""


echo [INFO] Services werden gestartet...

start  mvn -f user_service\pom.xml spring-boot:run
start mvn -f storage_service\pom.xml spring-boot:run
start  mvn -f search_service\pom.xml spring-boot:run
start  mvn -f post_service\pom.xml spring-boot:run
