# 1.- Introducción - Layouts básicos y Composables.

# **1️⃣ Introducción a Jetpack Compose**

Jetpack Compose es el **framework moderno de UI de Android**, basado en Kotlin, que permite construir interfaces de manera **declarativa**.

- No se usan `XML` para el diseño.
- Todo UI se construye mediante **funciones composables**.
- Composable: una función anotada con `@Composable` que describe la UI.

### **Ejemplo de función composable**

```kotlin
@Composable
fun Saludo(nombre: String) {
    Text(text = "Hola, $nombre!")
}
```

Para mostrarlo, se llama desde `setContent` en la Activity:

```kotlin
setContent {
    Saludo(nombre = "DAM2")
}

```

# 2️⃣ Layouts básicos

### 2.1 Box

- `Box` coloca **elementos uno sobre otro**.
- Útil para **superponer elementos** o centrar contenido.

```kotlin
@Composable
fun EjemploBox() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Red),
        contentAlignment = Alignment.Center // centra el contenido dentro
    ) {
        Text("Texto centrado", color = Color.White)
    }
}
```

💡 Nota: puedes poner varios elementos dentro de un `Box`; se apilan **de arriba a abajo** (el último se dibuja encima).

---

### **2.2 Column**

- `Column` organiza elementos **verticalmente**, uno debajo del otro.
- `horizontalAlignment` controla la alineación horizontal de los elementos.
- `verticalArrangement` controla la distribución vertical dentro de la columna.

```kotlin
@Composable
fun EjemploColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text("Item 1")
        Text("Item 2")
        Button(onClick = {}) {
            Text("Botón")
        }
    }
}
```

### 2.3 Row

- `Row` organiza elementos **horizontalmente**, uno al lado del otro.
- `verticalAlignment` controla la alineación vertical de los elementos dentro de la fila.
- `horizontalArrangement` controla el espacio horizontal.

```kotlin
@Composable
fun EjemploRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Izquierda")
        Text("Derecha")
    }
}
```

---

### **2.4 Spacer**

- `Spacer` crea **espacio vacío** dentro de `Row` o `Column`.
- Se usa para separar elementos o rellenar espacio.

```kotlin
@Composable
fun EjemploSpacer() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Arriba")
        Spacer(modifier = Modifier.height(20.dp))  // 20dp de espacio
        Text("Abajo")
    }
}

```

# **3️⃣ Combinar Box, Column, Row y Spacer**

```kotlin
@Composable
fun LayoutCompleto() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Text("Box 1", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text("Item 1")
            Text("Item 2")
            Text("Item 3")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Item A", color = Color.White)
            Text("Item B", color = Color.White)
        }
    }
}
```

💡 Con esto puedes crear layouts **verticales, horizontales y apilados**, combinando Box, Row, Column y Spacer.

---

## **4️⃣ Tips importantes**

- Siempre usa `Modifier` para:
    - Tamaño (`fillMaxWidth`, `fillMaxSize`, `width`, `height`)
    - Padding/margin (`padding`)
    - Color de fondo (`background`)
- Para layouts que podrían exceder la pantalla, usa **`verticalScroll` o `horizontalScroll`**.
- `Spacer` es ideal para **separar elementos de forma flexible**.
- Combina `Column` + `Row` + `Box` para layouts complejos.