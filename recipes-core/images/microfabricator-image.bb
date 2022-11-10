DESCRIPTION = "Fairly minimal image for microfabricator app (microfabricator)"
LICENSE = "MIT"

inherit core-image

DEPENDS += "rpi-bootfiles"

IMAGE_FEATURES += "\
    splash \
    ssh-server-dropbear \
    debug-tweaks \
"

IMAGE_INSTALL += " \
    packagegroup-microfabricator-devtools \
    packagegroup-qml-basic \
    packagegroup-qml-multimedia \
    microfabricator \
    mfab-status-led \
    fluent-bit \
"

# Add an extra 0.5 GB of free space to the root filesystem
IMAGE_ROOTFS_EXTRA_SPACE = "524288"

