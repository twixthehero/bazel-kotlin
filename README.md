# bazel-kotlin

Example Bazel workspace configured to build a Kotlin program binary.

## Usage

### Running

```bash
$ bazel run //example
$ bazel run //example -- -h
```

### Adding new Java dependencies

1. Add the new dependency as a `maven_install` artifact in `WORKSPACE`.

```starlark
maven_install(
    artifacts = [
        "commons-cli:commons-cli:1.5.0",
        "<groupId>:<artifactId>:<version>",
    ],
)
```

2. Use the new dependency. Convert all dashes (`-`) to underscores (`_`).

```starlack
java_library(
   deps = [
      "@maven//:commons_cli_commons_cli",
      "@maven//:<group_id>_<artifact_id>",
   ],
)
```

# License

MIT
