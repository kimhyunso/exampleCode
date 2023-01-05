echo "project name : "
read name
django-admin startproject $name
`mkdir $name/templates`
`touch $name/templates/base.html`
