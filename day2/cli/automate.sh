#!/bin/sh

DATE_NOW=$(date)
ROOT_NAME=$1
FB=$2
LINKEDIN=$3 

#validate
if [ -z "$1" ]
  then
    echo "No argument supplied"
    exit
fi

#compose directory
ROOT_DIR="${ROOT_NAME} ${DATE_NOW}"
rm -rf "${ROOT_DIR}"
mkdir "${ROOT_DIR}"

#create about_me
cd "${ROOT_DIR}"
mkdir about_me
cd about_me

mkdir personal
cd personal
touch facebook.txt
echo "https://www.facebook.com/${FB}" > facebook.txt

cd ..
mkdir professional
cd professional
touch linkedin.txt
echo "https://www.linkedin.com/in/${LINKEDIN}" > linkedin.txt

##create my_friends
cd ../..
mkdir my_friends
cd my_friends
SOURCE_URL="https://gist.githubusercontent.com/tegarimansyah/e91f335753ab2c7fb12815779677e914/raw/94864388379fecee450fde26e3e73bfb2bcda194/list%2520of%2520my%2520friends.txt"
curl -s "${SOURCE_URL}" > list_of_my_friends.txt

##create my_system_info
cd ..
mkdir my_system_info
cd my_system_info
touch about_this_laptop.txt
USERNAME=$(whoami)
SYSTEM_INFO=$(uname -a)
echo "My username: ${USERNAME}" > about_this_laptop.txt
echo "With host: ${SYSTEM_INFO}" >> about_this_laptop.txt
ping -c 4 google.com > internet_connection.txt
