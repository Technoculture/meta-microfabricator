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
    git://github.com/TechnocultureResearch/Microfabricator-HMI.git;protocol=http;branch=v4 \
    file://microfabricator.service \
     file://customsplash.service \
     file://mfab-status-led.service \
     file://rauchawkbitupdate.service \
     file://fluent-bit.service \
     file://config.conf \
     file://logo.mp4 \
"
#SRC_URI = " file://Microfabricator-HMI/"
#SRC_URI += " file://microfabricator"

SRCREV = "bbabc5cc8b1e61c3c9e1725d65bc84508e2e5de3"

PV = "1.0+git${SRCREV}"

DEPENDS = "qtmultimedia qtcharts qtserialport mfab-status-led sqlite3 sqlite"

RDEPENDS_packagegroup-custom-apps = "mfab-status-led"
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "rauchawkbitupdate.service mfab-status-led.service customsplash.service microfabricator.service fluent-bit.service "

S = "${WORKDIR}/git"

do_install:append() {
  install -d ${D}${systemd_unitdir}/system
  install -m 0660 ${WORKDIR}/microfabricator.service  ${D}${systemd_unitdir}/system/
  install -m 0660 ${WORKDIR}/customsplash.service  ${D}${systemd_unitdir}/system/
  install -m 0660 ${WORKDIR}/mfab-status-led.service  ${D}${systemd_unitdir}/system/
  install -m 0660 ${WORKDIR}/rauchawkbitupdate.service  ${D}${systemd_unitdir}/system/
  install -m 0660 ${WORKDIR}/fluent-bit.service  ${D}${systemd_unitdir}/system/
  install -m 0660 ${WORKDIR}/logo.mp4  ${D}${systemd_unitdir}/system/
  install -m 0660 ${WORKDIR}/config.conf  ${D}${systemd_unitdir}/system/
  install -m 0660 ${WORKDIR}/git/mfab.db ${D}${systemd_unitdir}/system/
  mkdir   -p ${D}/usr/share/tcr
  install -m 0660 ${WORKDIR}/git/mfab.db ${D}/usr/share/tcr/
}

FILES:${PN} += "/usr/share/tcr"

FILES:${PN} += " \
    ${systemd_unitdir}/system/ \
"

FILES:${PN} += " \
    ${bindir}/mfab-status-led \
"

FILES:${PN} += " \
   "/usr/bin/${PN}" \
"


