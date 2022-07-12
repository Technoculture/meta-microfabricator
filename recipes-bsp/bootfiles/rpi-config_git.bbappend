# Enable audio subsystem in kernel and load kernel modules for sound (snd_*)
# at boot time. Loading sound modules through /etc/modules is too late such
# that sound doesn't work.

do_deploy:append() {
    echo "# Enable display and gpu driver" >> ${DEPLOYDIR}/bootfiles/config.txt
    echo "display_auto_detect=1" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
}
