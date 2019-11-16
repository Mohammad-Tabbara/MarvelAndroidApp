# MarvelAndroidApp
An App to show skills

![Platform](https://img.shields.io/badge/platform-Android-lightgrey.svg?style=flat) ![Kotlin Version](https://img.shields.io/badge/Kotlin-1.2.50-orange.svg) [![License](https://img.shields.io/badge/License-LGPL%20v3-blue.svg)](https://opensource.org/licenses/Apache-2.0) ![Maintenance](https://img.shields.io/maintenance/yes/2019.svg)

## SetUp

1 - Create a Marvel Account at: https://developer.marvel.com/

2 - Get Private and Public Keys and place them in the build.properties file(in home directory or root project):
```
MARVEL_API_PRIVATE_KEY = "PRIVATE_KEY"
MARVEL_API_PUBLIC_KEY = "PUBLIC_KEY"
```

3 - Set Up Project with Firebase: [Firebase Setup](https://firebase.google.com/docs/android/setup)

4 - Remove From build.gradle 

```
signingConfigs {
        release {
            keyAlias = MARVEL_keyAlias
            keyPassword MARVEL_keyAliasPassword
            storePassword MARVEL_keyStorePassword
            storeFile file(MARVEL_keyStore)
        }
    }
```


## Implemented

- Dependency Injection using dagger 2
- Clean architecture/MVP
- Networking Api calls
- Pagination
- Wiki WebView
- Offline Workflow
- Character Search Feature
- Room Database For Favorites
- Analytics and Crashlytics Integration


## Future

- Unit Tests With Travis CI