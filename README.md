# Bloom-Doom

Minecraft Forge mod project for Minecraft 1.20.1.

## Development setup

- JDK 17
- Gradle 8.8 (provided by the wrapper)

The Gradle wrapper uses Gradle 8.8, ForgeGradle, and official Minecraft mappings. On Windows, run `gradlew.bat runClient` to launch the development client or `gradlew.bat build` to build the mod jar in `build/libs/`.

## Current infection mechanics

The Bloom effect stacks to three levels and spreads when an infected living entity damages another entity: level I has a 40% chance, level II 70%, and level III 100%. The effect name is generated in `en_us`.

Entity conversion on death, infected mob variants, irregular forms, and the player-specific agony form are not implemented yet.
