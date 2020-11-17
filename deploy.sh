#!/bin/bash
set -e
UPLOAD='./gradlew publishMavenCentralPublicationToMavenRepository'
$UPLOAD || $UPLOAD || $UPLOAD || $UPLOAD || $UPLOAD
./gradlew publishPlugins || true
