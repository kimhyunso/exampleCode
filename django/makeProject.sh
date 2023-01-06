#!/bin/bash
echo "directory name : "
read directory
echo "project name : "
read name
`mkdir $directory ; django-admin startproject $name ./$directory`
`mkdir $directory/templates`
`touch $directory/templates/base.html`
