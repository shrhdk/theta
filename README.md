# Remote Shutter Tool

Remote shutter tool for RICOH THETA.

[![Build Status](https://travis-ci.org/shrhdk/theta.svg?branch=master)](https://travis-ci.org/shrhdk/theta)

## Requirements

- JDK 1.7

## How to Use CLI tool

(1) Build the CLI tool.

```
$ ./gradlew :cli:distribute
```

(2) Set up Wi-Fi to connect to RICOH THETA.

(3) Execute remote shutter.

```
$ ./cli/build/bin/theta-cli
```

## How to Use GUI tool

(1) Build the GUI tool.

```
$ ./gradlew :gui:distribute
```

(2) Set up Wi-Fi to connect to RICOH THETA.

(3) Launch the GUI tool.

```
$ ./gui/build/bin/theta-gui
```

## License

```
Copyright 2015 Hideki Shiro

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
