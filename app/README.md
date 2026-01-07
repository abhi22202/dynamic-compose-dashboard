# Dynamic Dashboard using Jetpack Compose

This project implements a dynamic dashboard screen using Jetpack Compose, where UI widgets are rendered purely based on backend-provided metadata.  
The primary focus of this assignment is clean architecture, scalability, and proper state management rather than heavy UI styling.

---

## Overview

The dashboard consists of multiple widgets displayed in a vertical list.  
Each widget is rendered dynamically using metadata that specifies:
- the widget type (Banner or List)
- a unique instance identifier (`instanceId`)

No widget position or count is hardcoded in the UI.

---

##  How Widget Identity Is Handled

Each widget is uniquely identified using an `instanceId` received from backend metadata.

data class WidgetMeta(
    val type: WidgetType,
    val instanceId: String
)

type decides which widget to render

instanceId acts as the identity of that widget instance

The same widget type can appear multiple times with different instanceIds

For stateful widgets (List widgets), instanceId is passed to the ViewModel to ensure that each widget instance owns its own state and does not interfere with others.

This approach guarantees proper state isolation even when multiple widgets of the same type are rendered.

📈 How Banner & List Widgets Scale
Banner Widget
Banner widgets are completely stateless

They receive all required data as parameters

Data is generated synchronously based on instanceId

Multiple banner widgets can be rendered safely using the same composable

Because the Banner widget does not own any state, adding new banner widgets only requires updating backend metadata — no UI changes are needed.

List Widget
    List widgets are stateful

Each List widget owns its own ViewModel

The ViewModel is initialized using the widget’s instanceId

ListWidgetViewModel(instanceId)

This allows:
    Multiple List widgets on the same screen
    Independent data fetching
    Independent loading, success, and error states
    The same List widget composable can safely scale to any number of instances without shared state issues.

🔄 How List Widget State Works
Each List widget follows a simple UI state model:
    sealed class ListWidgetState {
        object Loading
        data class Success(val data: List<ListWidgetConfig>)
        data class Error(val message: String)
    }

State flow:
    Widget is rendered
    ViewModel starts data fetching
    UI initially shows loading state
    UI updates to success or error based on the result
    Each List widget reacts only to its own ViewModel’s state, ensuring clean separation and predictable behavior.

🚀 What I Would Improve Next
 Given more time, the following improvements could be added:
    1.ViewModel factory for better lifecycle handling
    2.Retry mechanism for failed list widgets
    3.Pagination support for large lists
    4.Real API integration instead of fake data generators
    5.Widget-level caching to reduce unnecessary recompositions

🛠 Tech Stack

    Kotlin
    Jetpack Compose
    MVVM Architecture
    Coroutines