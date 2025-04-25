"use client"

import { useEffect, useRef } from "react"

export function AnimatedBackground() {
  const canvasRef = useRef<HTMLCanvasElement>(null)

  useEffect(() => {
    const canvas = canvasRef.current
    if (!canvas) return

    const ctx = canvas.getContext("2d")
    if (!ctx) return

    // Set canvas dimensions
    const resizeCanvas = () => {
      canvas.width = window.innerWidth
      canvas.height = window.innerHeight
    }

    resizeCanvas()
    window.addEventListener("resize", resizeCanvas)

    // Create floating card particles
    const particles: Particle[] = []
    const particleCount = 20

    class Particle {
      x: number
      y: number
      size: number
      speedX: number
      speedY: number
      rotation: number
      rotationSpeed: number
      opacity: number
      color: string

      constructor() {
        this.x = Math.random() * canvas.width
        this.y = Math.random() * canvas.height
        this.size = Math.random() * 20 + 10
        this.speedX = (Math.random() - 0.5) * 0.5
        this.speedY = (Math.random() - 0.5) * 0.5
        this.rotation = Math.random() * 360
        this.rotationSpeed = (Math.random() - 0.5) * 0.5
        this.opacity = Math.random() * 0.2 + 0.1

        // One Piece themed colors
        const colors = ["#E60012", "#0068B7", "#009944", "#FFF100", "#522785"]
        this.color = colors[Math.floor(Math.random() * colors.length)]
      }

      update() {
        this.x += this.speedX
        this.y += this.speedY
        this.rotation += this.rotationSpeed

        // Bounce off edges
        if (this.x > canvas.width || this.x < 0) {
          this.speedX = -this.speedX
        }
        if (this.y > canvas.height || this.y < 0) {
          this.speedY = -this.speedY
        }
      }

      draw() {
        ctx.save()
        ctx.translate(this.x, this.y)
        ctx.rotate((this.rotation * Math.PI) / 180)
        ctx.globalAlpha = this.opacity

        // Draw a card shape
        ctx.fillStyle = this.color
        ctx.fillRect(-this.size / 2, -this.size / 1.4, this.size, this.size * 1.4)

        // Card border
        ctx.strokeStyle = "rgba(255, 255, 255, 0.5)"
        ctx.lineWidth = 1
        ctx.strokeRect(-this.size / 2, -this.size / 1.4, this.size, this.size * 1.4)

        // Card details (simple lines to suggest text/image)
        ctx.fillStyle = "rgba(255, 255, 255, 0.3)"
        ctx.fillRect(-this.size / 2 + 2, -this.size / 1.4 + 2, this.size - 4, this.size / 3)

        ctx.restore()
      }
    }

    // Initialize particles
    for (let i = 0; i < particleCount; i++) {
      particles.push(new Particle())
    }

    // Animation loop
    const animate = () => {
      ctx.clearRect(0, 0, canvas.width, canvas.height)

      // Update and draw particles
      particles.forEach((particle) => {
        particle.update()
        particle.draw()
      })

      requestAnimationFrame(animate)
    }

    animate()

    // Cleanup
    return () => {
      window.removeEventListener("resize", resizeCanvas)
    }
  }, [])

  return <canvas ref={canvasRef} className="fixed top-0 left-0 w-full h-full -z-10 opacity-70" />
}
