# Enable option to detect the display automatically

do_deploy:append() {
    echo "# Enable display and gpu driver" >> ${DEPLOYDIR}/bootfiles/config.txt
    echo "display_auto_detect=1" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
}
