# weston-init.bbappend

# Add the path to your custom files
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# Replace the original files with your modified versions
SRC_URI += " \
    file://weston.ini \
    file://weston.service \
"
