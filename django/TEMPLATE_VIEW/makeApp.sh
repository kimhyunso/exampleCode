#!/bin/bash
echo "projectName : "
read name
python manage.py startapp $name
`mkdir $name/templates`
`touch $name/urls.py`
