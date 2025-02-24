# rpi-cmdline.bbappend

# Add the CMDLINE_CONSOLEBLANK variable
CMDLINE_CONSOLEBLANK ?= "consoleblank=0"

# Append the CMDLINE_CONSOLEBLANK to the CMDLINE variable
CMDLINE += " \
    ${CMDLINE_CONSOLEBLANK} \
"
