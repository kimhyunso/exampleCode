#!/bin/bash
root_dir = ""

echo "your Directory : "
read directory
echo "projectName : "
read name
python manage.py startapp `./$directory/$name`
`mkdir $name/templates`
`touch $name/urls.py`

