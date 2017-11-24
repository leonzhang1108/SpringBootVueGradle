<template>
  <div class="canvas-wrap">
    <canvas id="canvas" class="canvas"></canvas>
  </div>
</template>
<script>
export default {
  data: function () {
    return {}
  },
  mounted: function () {
    let c = document.getElementById('canvas')
    let ctx = c.getContext('2d')
    let i = 0
    let j = 0
    let x = 0
    let y = 0
    let size = 5
    let sizeDraw = size - 1
    let cols = 100
    let rows = 100
    let count = cols * rows
    let cells = []
    let tick = 0
    let nbCount = 0
    let framesModel = true
    let curr = 0

    c.width = size * cols
    c.height = size * cols
    let init = () => {
      for (i = 0; i < count; i++) cells.push([false, 0])
      restart()
    }

    let restart = () => {
      ctx.clearRect(0, 0, c.width, c.height)
      for (i = 0; i < count; i++) {
        // 一行1一行0
        cells[i][0] = ~~(i / rows) % 2
        // 随机
        // cells[i][0] = getRandom()
      }
      framesModel = !framesModel
      tick = 0
    }

    let doSin = () => {
      let getnbCountSin = i => {
        nbCount = 0
        for (j = 0; j < 9; j++) {
          if (j !== 4) {
            x = i % cols - 1 + j % 3
            y = Math.floor(i / cols) - 1 + Math.floor(j / 3)
            x >= 0 &&
              x < cols &&
              y >= 0 &&
              y < rows &&
              cells[y * cols + x][0] &&
              nbCount++
          }
        }
        return nbCount
      }
      let stepSin = () => {
        cells.forEach((cell, i) => (cell[1] = getnbCountSin(i)))
        cells.forEach(cell => {
          if (cell[0]) {
            (cell[1] < 2 || cell[1] > 3) && (cell[0] = 0)
          } else {
            cell[1] === 3 && (cell[0] = 1)
          }
        })
      }
      let drawSin = () => {
        ctx.beginPath()
        cells.forEach(
          (cell, i) =>
            cell[0] &&
            ctx.rect((i % cols) * size, ~~(i / cols) * size, sizeDraw, sizeDraw)
        )
        ctx.fillStyle =
          'hsla(0, 0%, ' +
          (0.5 + Math.sin(tick++ / 100) * 0.5) * 100 +
          '%, 0.1)'
        ctx.fill()
      }
      stepSin()
      drawSin()
    }

    let doFrame = () => {
      let getnbCountFrame = i => {
        nbCount = 0
        for (j = 0; j < 9; j++) {
          if (j !== 4) {
            x = i % cols - 1 + j % 3
            y = Math.floor(i / cols) - 1 + Math.floor(j / 3)
            if (x >= 0 && x < cols && y >= 0 && y < rows) {
              curr = y * cols + x
              cells[curr][0] && cells[curr][0] !== 2 && nbCount++
            }
          }
        }
        return nbCount
      }
      let stepFrame = () => {
        cells.forEach((cell, i) => (cell[1] = getnbCountFrame(i)))
        cells.forEach(cell => {
          if (cell[0] && cell[0] !== 2) {
            (cell[1] < 2 || cell[1] > 3) && (cell[0] = 2)
          } else {
            cell[1] === 3 && (cell[0] = 1)
          }
        })
      }
      let drawFrame = () => {
        cells.forEach((cell, i) => {
          ctx.beginPath()
          ctx.rect((i % cols) * size, ~~(i / cols) * size, sizeDraw, sizeDraw)
          switch (cell[0]) {
            case 0:
              ctx.fillStyle = '#fff'
              break
            case 1:
              ctx.fillStyle = '#505050'
              break
            case 2:
              ctx.fillStyle = '#B0B0B0'
              break
          }
          ctx.fill()
          ctx.closePath()
        })
      }
      stepFrame()
      drawFrame()
    }

    let loop = () => {
      requestAnimationFrame(loop)
      framesModel ? doFrame() : doSin()
    }

    window.addEventListener('click', restart)
    init()
    loop()
  }
}
</script>
<style>
.canvas-wrap {
  background: #000;
}
canvas {
  bottom: 0;
  left: 0;
  margin: auto;
  position: absolute;
  right: 0;
  top: 0;
}
</style>
