# ChalkySMP Items

A Fabric mod for Minecraft Java Edition 1.21.11.

## Development versions

- Minecraft: 1.21.11
- Fabric Loader: 0.20.1
- Fabric API: 0.141.1+1.21.11
- Java: 21
- Fabric Loom: 1.14.10

## Current content

- **Haste Tonic** — a consumable item that grants Haste I for 60 seconds.
- The Haste Tonic appears in the Ingredients creative tab.

The Haste Tonic currently uses the vanilla honey bottle texture as a temporary placeholder.

## Build

The GitHub Actions workflow builds the mod automatically after pushes to `main`.

To build in a development environment with Gradle 9.8.2 and Java 21 installed, run:

```bash
gradle build
```

The mod JAR is written to `build/libs/`.

## Reference project

The separate ChalkySMP Paper plugin repository is used as a read-only reference. This Fabric mod is maintained in this repository.
