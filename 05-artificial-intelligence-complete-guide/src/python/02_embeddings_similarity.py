"""
02_embeddings_similarity.py
Demonstrates semantic search and vector similarity computation using text embeddings.

Author: CodeByTushu
Website: https://codebytushu.com
"""

import math
from typing import List

def dot_product(v1: List[float], v2: List[float]) -> float:
    return sum(x * y for x, y in zip(v1, v2))

def magnitude(v: List[float]) -> float:
    return math.sqrt(sum(x * x for x in v))

def cosine_similarity(v1: List[float], v2: List[float]) -> float:
    """
    Computes cosine similarity between two vector embeddings.
    Cosine similarity ranges from -1.0 to 1.0 (1.0 = identical angle).
    """
    mag1 = magnitude(v1)
    mag2 = magnitude(v2)
    if mag1 == 0 or mag2 == 0:
        return 0.0
    return dot_product(v1, v2) / (mag1 * mag2)

if __name__ == "__main__":
    # Simulated vector embeddings (dimensions: 4)
    # Query: "React hooks tutorial"
    query_vector = [0.82, 0.45, 0.12, 0.31]
    
    # Doc A: "React Frontend Guide with useState and useEffect"
    doc_a_vector = [0.80, 0.43, 0.15, 0.33]
    
    # Doc B: "Complete SQL Database normalization"
    doc_b_vector = [0.10, -0.20, 0.75, 0.60]

    sim_a = cosine_similarity(query_vector, doc_a_vector)
    sim_b = cosine_similarity(query_vector, doc_b_vector)

    print("=== Semantic Search Embedding Similarity ===")
    print(f"Similarity with React Guide (Doc A): {sim_a:.4f} (High Semantic Match)")
    print(f"Similarity with SQL Guide (Doc B):   {sim_b:.4f} (Low Semantic Match)")
