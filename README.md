# TMSX

TMSX is an emulator, written in Java, for the Z80-based [MSX](https://en.wikipedia.org/wiki/MSX) computer, a home computer standard from the eighties that was popular mainly in mainland Europe and Japan.
Like many home computers from that era, the MSX came with a built-in BASIC interpreter. What makes the MSX great is that it has a huge library of games, many of these games are early varsions of games that later became famous for their game console versions (Metal Gear, Nemesis, Contra, Bubble Bobble).

All parts of the emulator (such as the [Z80](https://en.wikipedia.org/wiki/Z80) and the [TMS9918 video display processor](https://en.wikipedia.org/wiki/TMS9918)) were written from scratch, except for the PSG sound emulation (see [here](MSXEMU/src/emu/AY38910.java)).
This project was undertaken mainly for personal recreational purposes. 
Other emulators exist that are much better (such as [OpenMSX](http://openmsx.org)).
That said, I believe the source code of TMSX is much simpler and therefore easier to understand than some of the other MSX emulators out there.
So, if you're interested in learning how an MSX emulator works, TMSX might be of interest.

## Current status

- Almost full MSX1 emulation.
- Runs many Konami games (Penguin Adventure, Nemesis I/II/III, Frogger, Knightmare, Kings Valley 2 and many more).
- Some games don't work (F1 Spirit) or are buggy (Goonies).

This project is work in progress. At the moment, things that need to be done are:

- Fix incompatibilities.
- Possibly: MSX2 Emulation and disk emulation.

## How to use

### Building

An ANT build file is included (use target "jar" to create JAR file). If you don't use ANT, you can compile
and create a JAR file as follows. Make sure you're in the root directory (containing the sub-directory `src`). 

```
mkdir build
javac -d build -cp src src/emu/ui/TMSX.java
jar cvfe TMSX.jar emu/ui/TMSX -C build. .
```

Start the JAR file as usual:

```
java -jar TMSX.jar
```

### Setting the system ROM

To use the emulator, you need to set the system ROM. You can use either the free [C-BIOS](http://cbios.sourceforge.net) or a ROM image of an
actual MSX1 computer. If you use C-BIOS, use the cbios_main_msx1.rom file which is included in the dowload that you can find on the [C-BIOS website](http://cbios.sourceforge.net).
ROM images of actual MSX computers can be found at various places on the web ([here](http://bluemsx.msxblue.com/resource.html) for example). The emulator was developed using a ROM image of a 
Toshiba HX-10 MSX1 computer with international keyboard layout, but ROM images of other MSX1 computers should work too, as long as they assume an international keyboard layout.
Upon starting 
the emulator for the first time, only the "Set System ROM" button is enabled. Click it and select the system ROM file that you want to 
use.

### Running games

ROM images of cartridges can be downloaded at various places on the web. Different cartridges require a different mapping mechanism. By default, 16/32K roms are mapped directly, which should work for most games. Roms larger than 32K require a more complicated mapping mechanism. Two of these are implemented, the so called "Konami4" and "Konami5" mappers. The choice has to be selected manually after loading a cartridge (automatic detection is not yet implemented). Games that require the Konami4 mapper include Nemesis I and Penguin Adventure. Games that require the Konami5 mapper include Nemesis II/III, Parodius and King's Valley II. For other games you might want to try out both and see which one works. 

## Screenshots

MSX BASIC

![MSX BASIC](/MSXEMU/screenshots/msxbasic.tiff?raw=true)

Konami Panguin Adventure

![Antarctic Adventure](/MSXEMU/screenshots/penguin%20adventure.tiff?raw=true)

Konami Frogger

![Frogger](/MSXEMU/screenshots/frogger.tiff?raw=true)

NAMCO Pac Man

![Pacman](/MSXEMU/screenshots/pacman.tiff?raw=true)

Konami Tennis

![Konami Tennis](/MSXEMU/screenshots/tennis.tiff?raw=true)

Konami Nemesis II

![Konami Tennis](/MSXEMU/screenshots/nemesis%202.tiff?raw=true)

Konami King's Valley 2

![Kings Valley](/MSXEMU/screenshots/King's%20Valley%202.tiff?raw=true)

Konami Knightmare

![Kings Valley](/MSXEMU/screenshots/knightmare.tiff?raw=true)

*Author: Tjitze Rienstra (tjitze@gmail.com).*
