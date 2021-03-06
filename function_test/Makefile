##############################################################################
# Copyright (c) 2000-2019 Ericsson Telecom AB
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v2.0
# which accompanies this distribution, and is available at
# https://www.eclipse.org/org/documents/epl-2.0/EPL-2.0.html
#
# Contributors:
#   Balasko, Jeno
#   Baranyi, Botond
#   Bartha, Norbert
#   Delic, Adam
#   Kovacs, Ferenc
#   Ormandi, Matyas
#   Raduly, Csaba
#   Kristof, Szabados
#
##############################################################################
# Makefile to run the non-interactive tests
DIRS := Semantic_Analyser Semantic_Analyser_Csaba Config_Parser

SCRIPTFLAGS :=

# Coverage settings
LCOVDIR := /mnt/TTCN/Tools/lcov-1.7/usr
LCOV := no
ifeq ($(LCOV), yes)
SCRIPTFLAGS += -coverage
endif
# Runtime selection
#RT2 := yes
ifdef RT2
SCRIPTFLAGS += -rt2
endif

# Your platform. Allowed values: SOLARIS, SOLARIS8, LINUX, FREEBSD, WIN32
ifndef PLATFORM
PLATFORM1 := $(shell uname -s)
PLATFORM2 := $(shell uname -r)
PLATFORM3 := $(shell uname -m)

ifeq ($(PLATFORM1), SunOS)
  ifeq ($(PLATFORM2), 5.6)
    PLATFORM := SOLARIS
  else
    PLATFORM := SOLARIS8
  endif # 5.6
endif # SunOS
ifeq ($(PLATFORM1), Linux)
  PLATFORM := LINUX
endif # Linux
ifeq ($(PLATFORM1), FreeBSD)
  PLATFORM := FREEBSD
endif # FreeBSD
ifeq ($(findstring CYGWIN, $(PLATFORM1)), CYGWIN)
  PLATFORM := WIN32
endif # CYGWIN
ifeq ($(PLATFORM1), Interix)
  PLATFORM := INTERIX
endif # Interix
endif # ifndef PLATFORM
ifndef PLATFORM
	PLEASE CHECK THE ABOVE PLATFORM SETTINGS!!!
endif # ifndef PLATFORM

export PLATFORM
export RT2

all check run: $(DIRS)

.PHONY: $(DIRS)

BER_EncDec:
	cd $@; make -j; make run

RAW_EncDec:
	cd $@; make -j; make run

Text_EncDec:
	cd $@; make -j; make run

XER_EncDec:
	cd $@; make -j; make run
	
OER_EncDec:
	cd $@; make -j; make run

Semantic_Analyser:
	cd $@; if [ ! -f perl ] ; then ln -s `which perl` perl; fi; ./run_test_all $(SCRIPTFLAGS)

Semantic_Analyser_Csaba:
	make run -f Makefile.semantic -C Semantic_Analyser

Config_Parser:
	cd $@; if [ ! -f perl ] ; then ln -s `which perl` perl; fi; ./run_test $(SCRIPTFLAGS)

profile: $(DIRS)
	make all
	$(LCOVDIR)/bin/lcov -d .. -c -o functest_coverage.info
	$(LCOVDIR)/bin/genhtml -o functest_coverage -t "TITAN Function Test Coverage" functest_coverage.info

# It's a 50-50
clean:
	for d in $(DIRS); do if [ -f $$d/Makefile ]; then $(MAKE) -C $$d clean; else : ; fi done

$(CURDIR)/Makefile.personal:
	ln -s $(CURDIR)/../$(@F) $(CURDIR)/
include $(CURDIR)/Makefile.personal
