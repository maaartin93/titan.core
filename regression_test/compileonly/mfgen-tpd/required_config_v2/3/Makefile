##############################################################################
# Copyright (c) 2000-2019 Ericsson Telecom AB
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v2.0
# which accompanies this distribution, and is available at
# https://www.eclipse.org/org/documents/epl-2.0/EPL-2.0.html
#
# Contributors:
#   Szabo, Bence Janos
#
##############################################################################
TOPDIR := ../../../..
include $(TOPDIR)/Makefile.regression

ifdef LCOV
COVERAGE_FLAG := -C
endif

# ${MAKEPROG} has the same content as the built-in ${MAKE},
# except the special handling of ${MAKE} does not apply.
# If we used ${MAKE} in the rules below, 'make -n' would succeed once,
# then fail on every subsequent invocation until a 'make clean' is done. 

#This tests that 'a' references 'b' and 'b' references 'c' and 'a' requires
#'b''s '1' configuration and 'c''s '1' configuration.
#      a
# c:1 / 
# b:1/   
#   /     
#  b-------c

MAKEPROG := ${MAKE}

all: CheckTpd 

BuildTpd:
	$(TTCN3_DIR)/bin/ttcn3_makefilegen -f $(MFGEN_FLAGS) $(COVERAGE_FLAG) \
	-t a.tpd -g

CheckTpd: BuildTpd
	if [ ! -f "./binDefault/Makefile" ] || [ ! -L "./binDefault/aDefault.ttcn" ] || [ -L "./binDefault/a1.ttcn" ]; \
	then echo "Makefilegen required config test 3 failed: Overall verdict: fail" && exit 1; fi
	if [ ! -L "./binDefault/b1.ttcn" ] || [ -L "./binDefault/bDefault.ttcn" ]; \
	then echo "Makefilegen required config test 3 failed: Overall verdict: fail" && exit 1; fi
	if [ ! -L "./binDefault/c1.ttcn" ] || [ -L "./binDefault/cDefault.ttcn" ]; \
	then echo "Makefilegen required config test 3 failed: Overall verdict: fail" && exit 1; fi

clean:
	-rm -rf binDefault

distclean: clean
	-rm -f *.out

.PHONY: all clean distclean BuildTpd CheckTpd

