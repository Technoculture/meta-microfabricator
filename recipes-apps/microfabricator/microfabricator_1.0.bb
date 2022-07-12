SUMMARY = "This program providing a touch screen interface for the Microfabricator 4S machine"
AUTHOR = "Satyam Tiwary"
HOMEPAGE = "Local Directory"

SECTION = "app"

LICENSE = "MIT"
LIC_FILES_CHKSUM="file://LICENSE;md5=ccee66d4e72885d7f62bdde5d9f5ebd9"

inherit cmake_qt5
#inherit cmake_qt5 update-rc.d
PR = "r23"
inherit systemd

NATIVE_SYSTEMD_SUPPORT = "1"

SRC_URI = "\
    git://github.com/TechnocultureResearch/Microfabricator-HMI.git;protocol=http;branch=v1 \
    file://microfabricator.service \
"
#SRC_URI = " file://Microfabricator-HMI/"
#SRC_URI += " file://microfabricator"

SRCREV = "230772158ecd531b8b3c08d0c5c460a93482230c"

PV = "1.0+git${SRCREV}"

DEPENDS = "qtmultimedia qtcharts qtserialport"


SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "microfabricator.service"

S = "${WORKDIR}/git"

do_install:append() {
  install -d ${D}${systemd_unitdir}/system
  install -m 0660 ${WORKDIR}/microfabricator.service  ${D}${systemd_unitdir}/system/
}


FILES:${PN} += " \
    ${systemd_unitdir}/system/ \
"

FILES:${PN} += " \
   "/usr/bin/${PN}" \
"


