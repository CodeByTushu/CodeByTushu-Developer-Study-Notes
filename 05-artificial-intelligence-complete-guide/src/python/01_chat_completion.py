"""
01_chat_completion.py
Demonstrates OpenAI / LLM Chat Completion API integration.

Author: CodeByTushu
Website: https://codebytushu.com
"""

import os
from openai import OpenAI
from dotenv import load_dotenv

load_dotenv()

client = OpenAI(api_key=os.getenv("OPENAI_API_KEY", "your-api-key-here"))

def generate_technical_explanation(topic: str) -> str:
    """
    Generates a structured, concise technical explanation with code examples.
    """
    response = client.chat.completions.create(
        model="gpt-4o-mini",
        messages=[
            {
                "role": "system",
                "content": "You are a senior software engineer from CodeByTushu. Provide clear, concise explanations with Big-O complexity."
            },
            {
                "role": "user",
                "content": f"Explain '{topic}' with a brief real-world example."
            }
        ],
        temperature=0.3,
        max_tokens=300
    )
    return response.choices[0].message.content

if __name__ == "__main__":
    topic = "Polymorphism vs Composition in OOP"
    print(f"=== Generating Explanation for: {topic} ===")
    explanation = generate_technical_explanation(topic)
    print(explanation)
