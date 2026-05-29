# MiniBlog — A Repository Pattern Teaching Project (Android / Kotlin)

A tiny Android app used to teach the **Repository pattern**. The whole course revolves around **one**
app that evolves across **git branches** — the **diff between two adjacent branches IS one lesson**.

> This repository's root **is** the Android project — open the repo folder directly in Android Studio.

## Requirements
- **Android Studio**: Otter 3 Feature Drop or newer (required by AGP 9.0).
- **JDK 17** (the JDK bundled with Android Studio works fine).
- **Gradle 9.1** — preconfigured via the Gradle Wrapper (Studio downloads it on sync).
- An emulator or device running **Android 7.0 (API 24)** or higher.

## Run it
1. Open the repository folder in Android Studio and let Gradle sync.
2. Select the `app` configuration and press **Run**.
3. Behaviour depends on the branch you checked out (see the table). From `01-no-repository` onward,
   tap **Refresh** to fetch posts from the network into Room; the list then updates via LiveData.

## Learning path (study the branches in order)
| Branch | Lesson |
|---|---|
| `00-starter` | Foundation only: `Post` (@Entity), `PostDao` (LiveData), `AppDatabase`, layouts, full `build.gradle`. Retrofit & RecyclerView are left as **clearly-marked TODO stubs**. |
| `01-no-repository` | Working app. An `AndroidViewModel` holds BOTH the `api` and the `dao` directly (the anti-pattern we will fix). |
| `02-repository` | Extract `PostRepository`; slim the ViewModel down to a plain `ViewModel`. |
| `03-factory-di` | Add a `ViewModelFactory` + an `Application` that owns the database to wire the slim ViewModel (**manual DI**, no Hilt). |
| `04-testable` | `PostRepository` becomes an **interface**; add a `FakePostRepository` + one JUnit test. |

Compare any two steps, e.g.: `git diff 01-no-repository..02-repository`.

**Step-by-step solution guide:** open [`TODO-GUIDE.html`](TODO-GUIDE.html) in a browser.

## Tech stack
AGP 9.0.1 (built-in Kotlin 2.2.10) · Gradle 9.1 · Room 2.7 (KSP2, returns **LiveData**) · Retrofit 2.11
+ Moshi 1.15 (reflection) · LiveData + ViewModel (**no** Flow) · RecyclerView 1.3.2 · Glide 4.16 ·
**manual DI** (no Hilt). API: [JSONPlaceholder](https://jsonplaceholder.typicode.com/posts) (no key).

## Notes
- Each post row shows **title + body only** (JSONPlaceholder `/posts` has no images).
- **Glide** is kept in the stack but unused by the current UI — reserved for a later image-loading lesson.
- **KSP + AGP 9 built-in Kotlin:** `gradle.properties` sets `android.disallowKotlinSourceSets=false` so
  KSP 2.2.10's generated Room code compiles. Do NOT remove it while on KSP 2.2.x.
- If `gradle/wrapper/gradle-wrapper.jar` is ever missing, Android Studio regenerates it on sync
  (or run `gradle wrapper`).
