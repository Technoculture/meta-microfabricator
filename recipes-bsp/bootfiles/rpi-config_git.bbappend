# Enable option to detect the display automatically

do_deploy:append() {
    echo "# Enable display and gpu driver" >> ${DEPLOYDIR}/bootfiles/config.txt
    echo "display_auto_detect=1" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    echo "max_framebuffers=2" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    echo "disable_splash=1" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
    echo "gpu_mem=256" >> ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt
}
