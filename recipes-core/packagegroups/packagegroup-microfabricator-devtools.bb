DESCRIPTION = "Tools for target device during microfabricator development"
LICENSE = "MIT"
PR = "r0"

inherit packagegroup

RDEPENDS:${PN} = "\
    openssh-sftp-server \
    rsync \
"

