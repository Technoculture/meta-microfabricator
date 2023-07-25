SUMMARY = "Minimal set of Qt packages needed for QML apps"

inherit packagegroup

RDEPENDS:${PN} = " \
    fontconfig \
    ttf-bitstream-vera \
    qtbase \
    qtbase-plugins \
    qtdeclarative \
    qtdeclarative-qmlplugins \
    qtquickcontrols \
    qtquickcontrols2 \
    qtserialport \
    qtcharts \
    qtgraphicaleffects-qmlplugins \
"

