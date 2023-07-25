# Disable desktop OpenGL. Enable OpenGL ES and EGFLS.
PACKAGECONFIG_GL = "gles2 eglfs"

# Enable fontconfig to get system freetype fonts
PACKAGECONFIG_FONTS += "fontconfig"
PACKAGECONFIG:append += " sql-sqlite"
DEPENDS += "userland"
