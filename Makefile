.PHONY: help build clean test lint assemble debug release version-major version-minor version-patch

# Default target
help:
	@echo "PsychTests - Build Commands"
	@echo ""
	@echo "Build:"
	@echo "  make build        - Build debug APK"
	@echo "  make debug        - Build debug APK (alias)"
	@echo "  make release      - Build release APK"
	@echo "  make assemble     - Build both debug and release"
	@echo ""
	@echo "Version:"
	@echo "  make version-major - Bump major version (X.0.0)"
	@echo "  make version-minor - Bump minor version (X.Y.0)"
	@echo "  make version-patch - Bump patch version (X.Y.Z)"
	@echo ""
	@echo "Quality:"
	@echo "  make test         - Run unit tests"
	@echo "  make lint         - Run lint checks"
	@echo ""
	@echo "Maintenance:"
	@echo "  make clean        - Clean build artifacts"

# Build commands
build: debug

debug:
	./gradlew assembleDebug

release:
	./gradlew assembleRelease

assemble: debug release

# Version bumping
version-major:
	@current_major=$$(grep 'appVersionMajor' gradle/libs.versions.toml | cut -d'=' -f2 | tr -d ' "') ; \
	new_major=$$((current_major + 1)) ; \
	sed -i "s/appVersionMajor = \"$$current_major\"/appVersionMajor = \"$$new_major\"/" gradle/libs.versions.toml ; \
	sed -i "s/appVersionMinor = \".*\"/appVersionMinor = \"0\"/" gradle/libs.versions.toml ; \
	sed -i "s/appVersionPatch = \".*\"/appVersionPatch = \"0\"/" gradle/libs.versions.toml ; \
	echo "Version bumped to $$new_major.0.0"

version-minor:
	@current_minor=$$(grep 'appVersionMinor' gradle/libs.versions.toml | cut -d'=' -f2 | tr -d ' "') ; \
	new_minor=$$((current_minor + 1)) ; \
	current_major=$$(grep 'appVersionMajor' gradle/libs.versions.toml | cut -d'=' -f2 | tr -d ' "') ; \
	sed -i "s/appVersionMinor = \"$$current_minor\"/appVersionMinor = \"$$new_minor\"/" gradle/libs.versions.toml ; \
	sed -i "s/appVersionPatch = \".*\"/appVersionPatch = \"0\"/" gradle/libs.versions.toml ; \
	echo "Version bumped to $$current_major.$$new_minor.0"

version-patch:
	@current_patch=$$(grep 'appVersionPatch' gradle/libs.versions.toml | cut -d'=' -f2 | tr -d ' "') ; \
	new_patch=$$((current_patch + 1)) ; \
	current_major=$$(grep 'appVersionMajor' gradle/libs.versions.toml | cut -d'=' -f2 | tr -d ' "') ; \
	current_minor=$$(grep 'appVersionMinor' gradle/libs.versions.toml | cut -d'=' -f2 | tr -d ' "') ; \
	sed -i "s/appVersionPatch = \"$$current_patch\"/appVersionPatch = \"$$new_patch\"/" gradle/libs.versions.toml ; \
	echo "Version bumped to $$current_major.$$current_minor.$$new_patch"

# Testing and quality
test:
	./gradlew test

lint:
	./gradlew lint

# Clean
clean:
	./gradlew clean
	rm -rf app/build