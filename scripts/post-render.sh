#!/bin/sh

echo "initializing gradle wrapper"
gradle wrapper --gradle-version $gradle_version

for i in $(echo $subprojects | sed "s/,/ /g")
do
    # call your procedure/other scripts here below
    cp -r sub_module_template $i
    echo "include(\"${i}\")" >> settings.gradle.kts
    rm -f ${i}/src/main/java/.gitkeep
    rm -f ${i}/src/test/java/.gitkeep
    rm -f ${i}/src/main/resources/.gitkeep
    rm -f ${i}/src/test/resources/.gitkeep
done

rm -r -f sub_module_template
rm -r -f .rendr.yaml
echo "initializing git"
git init
git add .
git commit -m "${git_commit_msg}"

echo "Created project ${name}."

