#!/bin/bash
root_dir="~/exampleCode/django"

echo "your Directory : "
read directory
echo "projectName : "
read name
python manage.py startapp ./$directory/$name
`mkdir $directory/$name/templates`
`touch $directory/$name/urls.py`

