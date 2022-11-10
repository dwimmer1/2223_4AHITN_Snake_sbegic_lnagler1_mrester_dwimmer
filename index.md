Das ist die GitHub Page von Snake

![unknown](https://user-images.githubusercontent.com/67701825/199690770-ffec3047-584a-4826-979e-e9f2fe98f55c.png)


# Hier kommen sie zu den einzelnen Seiten

[AboutSUS](aboutSUS.md)

[Aboutus2](aboutUS.md)

[SpielErklärung](explanation.md)

[Bilder](GamePreview.md)

{% for element in site.data.students %}
- {{element.firstname}} {{element.lastname}}, {{element.class}}
{% endfor %}
