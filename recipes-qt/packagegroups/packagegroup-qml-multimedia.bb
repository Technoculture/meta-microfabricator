SUMMARY = "Additional multimedia packages for QML apps"

inherit packagegroup

RDEPENDS:${PN} = " \
    qtmultimedia \
    qtmultimedia-qmlplugins \
    qtmultimedia-plugins \
    qtcharts-dev \
    qtcharts-mkspecs \
    qtserialport-dev \
    qtserialport-mkspecs \
"

